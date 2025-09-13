import { Module } from "vuex";

interface AuthState {
  accessToken: string | null;
  refreshToken: string | null;
}

const auth: Module<AuthState, any> = {
  namespaced: true, // ✅ required for "auth/login"
  state: () => ({
    accessToken: null,
    refreshToken: null,
  }),
  mutations: {
    setTokens(state, { accessToken, refreshToken }) {
      state.accessToken = accessToken;
      state.refreshToken = refreshToken;
    },
  },
  actions: {
    async login({ commit }, { username, password }) {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
      });
      if (!response.ok) {
        throw new Error("Login failed");
      }
      const data = await response.json();
      commit("setTokens", {
        accessToken: data.accessToken,
        refreshToken: data.refreshToken,
      });
    },
  },
};

export default auth;
