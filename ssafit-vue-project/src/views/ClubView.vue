<template>
  <div>
    <div id="club-container">
      <div id="page-title">
        Club List
        <hr />
      </div>

      <div id="club-list">
        <ClubList
          v-for="club in store.clubList"
          :key="club.clubId"
          :club="club"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import ClubList from "@/components/club/ClubList.vue";

import { useClubStore } from "@/stores/club.js";
import { onMounted } from "vue";

const store = useClubStore();
// onMounted(() => {
//   store.getClubList;
// });
</script>

<style>
#club-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#page-title {
  font-size: 30px;
  width: 95%;
}

#club-list {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

hr {
  width: 100%;
}
</style>
