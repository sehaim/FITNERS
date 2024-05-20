<template>
  <div id="club-container">
    <div id="page-title">
      Club List
      <hr />
    </div>

    <div id="club-list">
      <ClubListItem
        v-for="club in store.clubList"
        :key="club.clubId"
        :club="club"
      />
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useClubStore } from "@/stores/club.js";
import ClubListItem from "@/components/club/ClubListItem.vue";


const store = useClubStore();

onMounted(() => {
  store.getClubList();
});
</script>

<style>
#club-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 2%;
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
