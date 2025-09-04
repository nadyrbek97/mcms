<script setup>
import Navbar from "@/components/Navbar.vue";
</script>

<template>
  <div class="container mt-4">
    <div>
      <Navbar />
      <router-view />
    </div>
  </div>
</template>

<style>
body {
  font-family: Arial, sans-serif;
}
</style>
