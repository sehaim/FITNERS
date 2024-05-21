<template>
  <div id="my-schedule-container">
    <div id="my-schedule-container-header">
      <div id="title">
        <img src="@/assets/img/myschedule-icon.png" alt="myschedule-icon" />
        <div>My Schedule</div>
      </div>
    </div>
    <MyScheduleList :loginUser="loginUser" />
  </div>
</template>

<script setup>
import MyScheduleList from "./MyScheduleList.vue";

defineProps({
  loginUser: Object,
});
</script>

<style scoped>
#my-schedule-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

#my-schedule-container-header {
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
