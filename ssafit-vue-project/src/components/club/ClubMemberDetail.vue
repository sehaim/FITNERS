<template>
  <div id="club-member-detail-container">
    <ClubSchedule />
    <ClubBoard />
  </div>
</template>

<script setup>
import ClubSchedule from './ClubSchedule.vue';
import ClubBoard from './ClubBoard.vue';
</script>

<style scoped>
#club-member-detail-container {
  display: flex;
  flex-direction: row;
}
</style>