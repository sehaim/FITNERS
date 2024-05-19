<template>
  <div id="club-detail-container">
    <div id="club-detail-header">
      <div id="club-welcome">Welcome <span id="club-name">{{ store.club.clubName }}</span> !</div>
      <div id="club-description">{{ store.club.clubDescription }}</div>
      <div id="club-manager-name">{{ store.club.userName }}</div>
    </div>
    <div id="club-detail-content">
      <ClubMemberNone v-if="store.status === 'NONE'" :clubId = "clubId"/>
      <ClubMemberProceeding v-if="store.status === 'PROCEEDING'" />
      <ClubMemberDetail id="club-member-detail" v-if="store.status === 'COMPLETED'" />
      <ClubManagerNone v-if="store.status === 'MANAGER'" />
    </div>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club";
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import ClubMemberNone from "@/components/club/ClubMemberNone.vue";
import ClubMemberProceeding from "@/components/club/ClubMemberProceeding.vue";
import ClubManagerNone from "@/components/club/ClubManagerNone.vue";
import ClubMemberDetail from "./ClubMemberDetail.vue";

const store = useClubStore();

const route = useRoute();

const clubId = ref(route.params.clubId)

onMounted(() => {
  store.getUser();
  store.getClub(clubId.value);
});
</script>

<style scoped>
#club-detail-header {
  height: 100px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-right: 3%;
  padding-left: 3%;
  background: linear-gradient(
      to top,
      rgba(67, 85, 197, 0) 10%,
      rgba(67, 85, 197, 0.03) 30%,
      rgba(67, 85, 197, 0.06) 50%,
      rgba(67, 85, 197, 0.09) 75%,
      rgba(67, 85, 197, 0.1) 100%
    );
}

#club-detail-content {
  display: flex;
  flex-direction: column;
}

#club-welcome {
  font-size: 30px;
  color: gray;
}

#club-name {
  color: rgb(54, 51, 51);
}

#club-description {
  font-size: 20px;
}

#club-member-detail {
  display: flex;
  flex-direction: row;
}

</style>