import axios, { AxiosError, InternalAxiosRequestConfig } from "axios";
import store from "@/store";

const api = axios.create({
  baseURL: "http://localhost:8080", // your backend URL
  headers: {
    "Content-Type": "application/json",
  },
});

// Request interceptor → attach access token
api.interceptors.request.use(
  (config: InternalAxiosRequestConfig): InternalAxiosRequestConfig => {
    const token = store.getters.getAccessToken;
    if (token) {
      config.headers = config.headers || {};
      config.headers["Authorization"] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response interceptor → refresh on 401
api.interceptors.response.use(
  (res) => res,
  async (error: AxiosError) => {
    const originalRequest = error.config as any;
    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      try {
        await store.dispatch("refreshToken");
        originalRequest.headers["Authorization"] =
          "Bearer " + store.getters.getAccessToken;
        return api(originalRequest);
      } catch (err) {
        store.dispatch("logout");
        window.location.href = "/login";
      }
    }
    return Promise.reject(error);
  }
);

export default api;
