<template>
  <div id="container">
    <div id="club-detail-header">
      <div>Welcome</div>
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const store = useClubStore();

const route = useRoute();
const router = useRouter();

onMounted(() => {
  store.getClub(route.params.clubId);
});
</script>
