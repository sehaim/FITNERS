<template>
  <div>
    <div id="club-container">
      <div id="page-title">
        Club List
        <hr />
      </div>

      <div id="club-list">
        <ClubList v-for="club in store.clubList" :key="club.id" />
      </div>
    </div>
  </div>
</template>

<script setup>
import ClubList from "@/components/club/ClubList.vue";

import { useClubStore } from "@/stores/club.js";
import { onMounted } from "vue";

const store = useClubStore();
onMounted(() => {
  store.getClubList;
});
</script>

<style>
#club-container {
  display: flex;
  flex-direction: column;
}

#page-title {
  font-size: 30px;
  width: 95%;
}

hr {
  width: 100%;
}
</style>
