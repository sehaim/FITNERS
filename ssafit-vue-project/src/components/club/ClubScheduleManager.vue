<template>
  <div>
    <div>스케줄 매니저</div>
    <div>
      <ClubScheduleItem v-for="clubSchedule in clubScheduleList" :key="clubSchedule.scheduleId" :clubSchedule="clubSchedule"/>
    </div>
  </div>
</template>

<script setup>
import ClubScheduleItem from './ClubScheduleItem.vue';

defineProps({
  clubScheduleList: Object
})


</script>