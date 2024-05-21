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
import { ref, onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClubListItem from "./MyClubListItem.vue";

const store = useMypageStore();

const props = defineProps({
  loginUser: Object,
});

onMounted(() => {
  store.getMyClubList(props.loginUser.userId);
});
</script>

<style scoped>
#myclub-list-container {
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
}
</style>
