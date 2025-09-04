<template>
  <div class="container text-center mt-5">
    <h1 class="display-1">404</h1>
    <h3 class="mb-4">Page Not Found</h3>
    <p class="mb-4">Sorry, the page you are looking for does not exist.</p>
    <router-link to="/" class="btn btn-primary"> Go to Home </router-link>
  </div>
</template>

<script setup>
// No JS needed
</script>

<style scoped>
h1 {
  font-size: 6rem;
  font-weight: bold;
  color: #dc3545; /* Bootstrap danger red */
}
</style>
