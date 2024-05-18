<template>
  <div>
    <div>아이템</div>
    <div>{{ clubSchedule.schedule }}</div>
  </div>
</template>

<script setup>

defineProps({
  clubSchedule: Object
})

</script>