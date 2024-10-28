<script setup>
import { ref } from "vue";
import FeedTypeSelect from "./typefeed_select.vue";

const props = defineProps({
  initialData: {
    type: Object,
    required: false,
  },
  buttonText: {
    type: String,
    required: false,
    defaultValue: "Сохранить",
  },
});

const emits = defineEmits(["submit"]);

const formData = ref({
  name: props.initialData?.name || "",
  typeFeed: props.initialData?.typeFeed || null,
  price: props.initialData?.price || "",
});

const handleFeedTypeChange = (updatedFeedType) => {
  formData.value.typeFeed = updatedFeedType;
};

const submitForm = () => {
  emits("submit", formData.value);
};
</script>

<template>
  <form>
    <div class="mb-3">
      <label for="name" class="form-label">Имя</label>
      <input type="text" class="form-control" id="name" v-model="formData.name" />
    </div>
    <div class="mb-3">
      <label for="typeFeed" class="form-label">Тип корма</label>
      <FeedTypeSelect :initial-value="formData.typeFeed?.id" @change="handleFeedTypeChange" />
    </div>
    <div class="mb-3">
      <label for="price" class="form-label">Стоимость</label>
      <input type="text" class="form-control" id="price" v-model="formData.price" />
    </div>
    <button
      type="button"
      class="btn btn-primary"
      @click="submitForm"
      :disabled="!formData.name || !formData.price || !formData.typeFeed"
    >
      {{ props.buttonText }}
    </button>
  </form>
</template>
