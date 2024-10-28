<script setup>
import { ref } from "vue";

const props = defineProps({
  initialData: {
    type: Object,
    required: false,
  }
});

const formData = ref({
  name: props.initialData?.name || "",
});
</script>

<template>
  <form>
    <div class="mb-3">
      <label for="name" class="form-label">Имя</label>
      <input type="text" class="form-control" id="name" v-model="formData.name" />
    </div>
  </form>
</template>
