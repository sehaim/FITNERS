<template>
  <div id="my-member-list-by-club-container">
    <div v-if="memberRegistList !== null">
      <div id="club-name">{{ myClub.clubName }}</div>
      <MyMemberListItem
        v-for="myMember in memberRegistList"
        :key="myMember.userId"
        :clubId="myClub.clubId"
        :myMember="myMember"
      />
      <hr v-if="myClub.clubId != myClubList.length" />
    </div>
  </div>
</template>

<script setup>
import MyMemberListItem from "./MyMemberListItem.vue";

defineProps({
  myClub: Object,
  myClubList: Object,
  memberRegistList: Object,
});
</script>

<style scoped>
#my-member-list-by-club-container {
  display: flex;
  flex-direction: column;
  width: 90%;
}

#club-name {
  font-size: 20px;
  font-weight: 600;
  color: #276699;
  margin: 10px 0;
}

hr {
  width: 100%;
}
</style>
