<template>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h4 class="card-title text-center mb-4">Login</h4>
            <form @submit.prevent="onSubmit">
              <div class="mb-3">
                <label class="form-label">Username</label>
                <input
                  type="text"
                  v-model="username"
                  class="form-control"
                  required
                />
              </div>
              <div class="mb-3">
                <label class="form-label">Password</label>
                <input
                  type="password"
                  v-model="password"
                  class="form-control"
                  required
                />
              </div>
              <button
                class="btn btn-primary w-100"
                type="submit"
                :disabled="loading"
              >
                {{ loading ? "Logging in..." : "Login" }}
              </button>
            </form>
            <div v-if="error" class="alert alert-danger mt-3">{{ error }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";

export default defineComponent({
  setup() {
    const store = useStore();
    const router = useRouter();

    const username = ref("");
    const password = ref("");
    const loading = ref(false);
    const error = ref("");

    const onSubmit = async () => {
      loading.value = true;
      error.value = "";
      try {
        await store.dispatch("login", {
          username: username.value,
          password: password.value,
        });
        router.push("/");
      } catch (e) {
        console.log(e);
        error.value = "Invalid username or password";
      } finally {
        loading.value = false;
      }
    };

    return { username, password, loading, error, onSubmit };
  },
});
</script>
