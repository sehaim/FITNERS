<template>
  <div id="full-container">
    <TheHeaderNav id="header" />
    <RouterView id="content" />
    <TheFooterNav id="footer" />
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import TheFooterNav from "@/components/common/TheFooterNav.vue";
</script>

<style scoped>
#full-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

#footer {
  margin-top: auto;
}
</style>
