<template>
  <div id="container"></div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted } from "vue";

onMounted(() => {
  store.getClub();
});
</script>
