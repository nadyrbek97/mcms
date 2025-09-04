<template>
  <div class="container mt-4">
    <h1 class="mb-4">Services</h1>

    <div v-if="loading" class="text-center">
      <div class="spinner-border text-success" role="status"></div>
    </div>

    <div v-else>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Currency</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="s in services" :key="s.id">
            <td>{{ s.title }}</td>
            <td>{{ s.description }}</td>
            <td>{{ s.price }}</td>
            <td>{{ s.currencyCode }}</td>
          </tr>
        </tbody>
      </table>
      <p v-if="services.length === 0">No services found</p>
    </div>

    <router-link to="/" class="btn btn-secondary mt-3"
      >Back to Departments</router-link
    >
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import api from "@/api/api.ts";
import { useRoute } from "vue-router";

const services = ref([]);
const loading = ref(true);
const route = useRoute();

onMounted(async () => {
  try {
    const res = await api.get("/service", {
      params: { departmentId: route.params.id },
    });
    services.value = res.data;
  } finally {
    loading.value = false;
  }
});
</script>
