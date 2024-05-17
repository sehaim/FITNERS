<template>
  <div>
    <div id="club-detail-header">
      <div>Welcome {{ store.club.clubName }}</div>
      <div>{{ store.club.clubDescription }}</div>
    </div>
    <div id="club-detail-content">
      <ClubMemberNone v-if="store.status === 'NONE'" :clubId = "route.params.clubId"/>
      <ClubMemberProceeding v-if="store.status === 'PROCEEDING'" />
      <ClubSchedule v-if="store.status === 'COMPLETED'" />
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import ClubMemberNone from "@/components/club/ClubMemberNone.vue";
import ClubMemberProceeding from "@/components/club/ClubMemberProceeding.vue";
import ClubSchedule from "@/components/club/ClubSchedule.vue";

const store = useClubStore();

const route = useRoute();

onMounted(() => {
  store.getClub(route.params.clubId);
});
</script>

<style scoped>
#club-detail-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}


</style>