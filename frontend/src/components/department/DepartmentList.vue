<template>
  <div class="container mt-4">
    <h1 class="mb-4">Departments</h1>

    <div v-if="loading" class="text-center">
      <div class="spinner-border text-primary" role="status"></div>
    </div>

    <div v-else>
      <div class="list-group">
        <router-link
            v-for="d in departments"
            :key="d.id"
            :to="{ name: 'services', params: { id: d.id }}"
            class="list-group-item list-group-item-action"
        >
          <h5 class="mb-1">{{ d.title }}</h5>
          <p class="mb-1">{{ d.description }}</p>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import api from "@/api/api.js";

const departments = ref([]);
const loading = ref(true);

onMounted(async () => {
  try {
    const res = await api.get("/department", {
      params: { medCenterId: "223e4567-e89b-12d3-a456-426614174000" }
    });
    departments.value = res.data;
  } finally {
    loading.value = false;
  }
});
</script>
