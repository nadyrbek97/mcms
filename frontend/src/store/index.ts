import { createStore, Store } from "vuex";
import axios from "../api/api";
import auth from "@/store/modules/auth";

export interface User {
  id: string;
  username: string;
  roles: string[];
}

export interface AuthState {
  accessToken: string | null;
  refreshToken: string | null;
  user: User | null;
}

const store = createStore<AuthState>({
  modules: {
    auth,
  },
  state: {
    accessToken: localStorage.getItem("accessToken"),
    refreshToken: localStorage.getItem("refreshToken"),
    user: null,
  },
  mutations: {
    SET_TOKENS(state, payload: { accessToken: string; refreshToken: string }) {
      state.accessToken = payload.accessToken;
      state.refreshToken = payload.refreshToken;
      localStorage.setItem("accessToken", payload.accessToken);
      localStorage.setItem("refreshToken", payload.refreshToken);
    },
    CLEAR_TOKENS(state) {
      state.accessToken = null;
      state.refreshToken = null;
      localStorage.removeItem("accessToken");
      localStorage.removeItem("refreshToken");
    },
    SET_USER(state, user: User) {
      state.user = user;
    },
  },
  actions: {
    async login({ commit }, creds: { username: string; password: string }) {
      const res = await axios.post("/auth/login", creds);
      commit("SET_TOKENS", {
        accessToken: res.data.accessToken,
        refreshToken: res.data.refreshToken,
      });
    },
    async refreshToken({ commit, state }) {
      if (!state.refreshToken) throw new Error("No refresh token");
      const res = await axios.post("/auth/refresh", {
        refreshToken: state.refreshToken,
      });
      commit("SET_TOKENS", {
        accessToken: res.data.accessToken,
        refreshToken: res.data.refreshToken,
      });
    },
    logout({ commit }) {
      commit("CLEAR_TOKENS");
    },
  },
  getters: {
    isAuthenticated: (state) => !!state.accessToken,
    getAccessToken: (state) => state.accessToken,
    getRefreshToken: (state) => state.refreshToken,
  },
});

export default store;

// type helper for components
export type StoreType = Store<AuthState>;
