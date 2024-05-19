<template>
  <div id="my-club-container">
    <div id="title">
      <div>My Club</div>
    </div>
    <MyClubList :myClubList="myClubList"/>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClubList from './MyClubList.vue';

const store = useMypageStore();

const myClubList = ref([]);

onMounted(() => {
  store.getMyClubList();
  myClubList.value = store.myClubList;
})
</script>

<style scoped>
#my-club-container {
  height: 100%;
  min-height: 100%;
  width: 50vw;
  min-width: 50vw;
  padding: 20px;
  display: flex;
  flex-direction: column;
}
</style>