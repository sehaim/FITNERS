<template>
  <div id="hot-board-list-container">
    <HomeHotBoardListItem
      v-for="hotBoard in store.hotBoardList"
      :key="hotBoard.boardId"
      :hotBoard="hotBoard"
    />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useHomeStore } from "@/stores/home.js";
import HomeHotBoardListItem from "./HomeHotBoardListItem.vue";

const store = useHomeStore();

onMounted(() => {
  store.getHotBoardList();
});
</script>

<style scoped>
#hot-board-list-container {
  height: 30%;
  min-height: 30%;
  display: flex;
  flex-direction: row;
  position: relative;
  top: -30%;
  z-index: 100;
  padding: 20px 40px;
  justify-content: space-between;
}
</style>
