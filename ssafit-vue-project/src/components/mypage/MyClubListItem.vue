<template>
  <div id="my-club-item-container">
    <RouterLink id="club-name" :to="`/club/${myClub.clubId}`">
    {{ myClub.clubName }}</RouterLink>
  </div>
</template>

<script setup>
defineProps({
  myClub: Object,
});
</script>

<style scoped>
#my-club-item-container {
  height: 50px;
  min-height: 50px;
  width: 70%;
  min-width: 300px;
  max-width: 350px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 0px 3px 1px #799dbb;
  margin: 20px 10px;
  border-radius: 10px;
  padding: 0 30px;
}

#club-name {
  margin: auto;
  font-size: 16px;
  color: rgb(52, 50, 50)
}
</style>
