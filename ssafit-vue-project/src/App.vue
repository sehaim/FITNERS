<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import TheFooterNav from "@/components/common/TheFooterNav.vue";
</script>

<template>
  <div id="container">
    <TheHeaderNav />
    <RouterView id="content" />
    <TheFooterNav />
  </div>
</template>

<style scoped>
#content {
  height: auto;
  min-height: 100%;
  padding-bottom: 100px;
}
</style>
