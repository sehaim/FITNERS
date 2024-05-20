<template>
  <div id="my-club-list-container">
    <MyClubListItem
      v-for="myClub in store.myClubList"
      :key="myClub.clubId"
      :myClub="myClub"
    />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClubListItem from "./MyClubListItem.vue";

const store = useMypageStore();

onMounted(() => {
  store.getMyClubList();
});
</script>

<style scoped>
#myclub-list-container {
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
}
</style>
