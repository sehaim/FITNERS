<template>
  <div>
    <MyPage v-if="store.isMypageActive" />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyPage from "@/components/mypage/MyPage.vue";

const store = useMypageStore();

onMounted(() => {
  store.getUser();
});
</script>
