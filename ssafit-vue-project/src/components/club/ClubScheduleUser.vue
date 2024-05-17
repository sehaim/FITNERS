<template>
  <div>
    <div>스케줄 유저</div>
    <ClubScheduleItem v-for="clubSchedule in clubScheduleList" :key="clubSchedule.scheduleId" :clubSchedule="clubSchedule" />
  </div>
</template>

<script setup>
import ClubScheduleItem from './ClubScheduleItem.vue';

const props = defineProps({
  clubScheduleList: Object
})

console.log(props.clubScheduleList)
</script>