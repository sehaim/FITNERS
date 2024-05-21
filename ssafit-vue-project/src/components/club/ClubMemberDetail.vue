<template>
  <div id="club-member-detail-container">
    <ClubSchedule />
    <ClubBoard :clubId="clubId"/>
  </div>
</template>

<script setup>
import ClubSchedule from "./ClubSchedule.vue";
import ClubBoard from "./ClubBoard.vue";

defineProps ({
  clubId: Number
})
</script>

<style scoped>
#club-member-detail-container {
  display: flex;
  flex-direction: row;
  padding-left: 5%;
  padding-right: 5%;
}
</style>
