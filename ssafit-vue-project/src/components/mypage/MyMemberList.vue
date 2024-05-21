<template>
  <div id="my-member-list-container">
    <MyMemberListByClub
      v-for="myClub in store.myClubList"
      :key="myClub.clubId"
      :myClub="myClub"
      :memberRegistList="store.memberRegistList"
    />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyMemberListByClub from "./MyMemberListByClub.vue";

const store = useMypageStore();

const props = defineProps({
  loginUser: Object,
});

onMounted(() => {
  store.getMyClubList(props.loginUser.userId);
  store.getMemberRegistList(props.loginUser.userId);
});
</script>

<style scoped>
#my-schedule-list-container {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
}

#my-schedule-list-container::-webkit-scrollbar {
  display: none;
}
</style>
