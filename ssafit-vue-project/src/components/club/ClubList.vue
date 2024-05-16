<template>
  <div id="container">
    <div>
      <RouterLink :to="`/club/${club.clubId}`">{{ club.name }}</RouterLink>
    </div>
    <div>{{ club.userId }}</div>
    <div>{{ club.description }}</div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";

const store = useClubStore();

defineProps({
  club: Object,
});
</script>

<style scoped>
#container {
  display: flex;
  flex-direction: column;
}
</style>
