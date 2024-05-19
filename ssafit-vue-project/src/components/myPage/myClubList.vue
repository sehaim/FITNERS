<template>
  <div id="my-club-list-container">
    <!-- <MyClubListItem v-for="myClub in myClubList :key="myClub" :myClub="myClub"/> -->
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClubListItem from './MyClubListItem.vue';

const store = useMypageStore();

defineProps({
  myClubList: Object
})

// onMounted(() => {
//   store.getMyClubList();
// })

</script>