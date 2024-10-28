<script setup>
import { ref, onMounted, watch } from "vue";
import { getAllTypeFeed } from "../api/typefeed";

const props = defineProps({
  initialValue: {
    type: Number,
    required: false,
  },
});

const emits = defineEmits(["change"]);

const feedTypes = ref([]);
const selectedType = ref(null);

onMounted(async () => {
  feedTypes.value = await getAllTypeFeed();

  if (props.initialValue) {
    const initialType = feedTypes.value.find((t) => t.id == props.initialValue);

    if (initialType) {
      selectedType.value = initialType;
    }
  }
});

watch(selectedType, () => {
  emits("change", selectedType.value);
  console.log(selectedType.value);
});
</script>

<template>
  <select v-if="feedTypes.length > 0" v-model="selectedType" class="form-select" aria-label="Default select example">
    <option v-for="type in feedTypes" :key="type.id" :value="type">{{ type.name }}</option>
  </select>
</template>
