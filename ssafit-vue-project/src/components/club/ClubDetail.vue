<template>
  <div id="container">
    <div id="club-detail-header">
      <div>Welcome {{ store.club.clubName }}</div>
      <div>{{ store.club.clubDescription }}</div>
    </div>
    <div id="club-detail-content">
      <ClubMemberNone v-if="store.status === 'NONE'" />
      <ClubMemberProceeding v-if="store.status === 'PROCEEDING'" />
      <ClubScheduleUser v-if="store.status === 'COMPLETED'" />
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import ClubMemberNone from "@/components/club/ClubMemberNone.vue";
import ClubMemberProceeding from "@/components/club/ClubMemberProceeding.vue";
import ClubScheduleUser from "@/components/club/ClubScheduleUser.vue";

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