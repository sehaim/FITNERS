<template>
  <div id="club-board-container">
    <div id="club-board-container-header">
      <div id="title">
        <img src="@/assets/img/notice-icon.png" alt="notice-icon">
        <div>Notice</div>
      </div>
    </div>
    <ClubBoardDetail :clubId="clubId"/>
  </div>
</template>

<script setup>
import ClubBoardDetail from './ClubBoardDetail.vue';

defineProps({
  clubId: Number
})
</script>

<style scoped>
#club-board-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
}

#club-board-container-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 15px;
}

#title {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 22px;
}

img {
  width: 40px;
  margin-right: 20px;
  opacity: 80%;
}
</style>
