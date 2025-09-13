<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">MyApp</router-link>
      <div class="d-flex ms-auto">
        <button v-if="isAuth" class="btn btn-outline-light" @click="logout">
          Logout
        </button>
        <router-link v-else class="btn btn-primary" to="/login"
          >Login</router-link
        >
      </div>
    </div>
  </nav>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";
import { useStore } from "vuex";

export default defineComponent({
  setup() {
    const store = useStore();
    const isAuth = computed(() => store.getters["auth/isAuthenticated"]);

    const logout = () => {
      store.dispatch("auth/logout");
    };

    return { isAuth, logout };
  },
});
</script>
