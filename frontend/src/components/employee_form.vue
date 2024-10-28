<script setup>
import { ref } from "vue";

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
  surname: props.initialData?.surname || "",
  middle_name: props.initialData?.middle_name || "",
  post: props.initialData?.post || "",
  phone_number: props.initialData?.phone_number || "",
});

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
      <label for="surname" class="form-label">Фамилия</label>
      <input type="text" class="form-control" id="surname" v-model="formData.surname" />
    </div>
    <div class="mb-3">
      <label for="middle_name" class="form-label">Отчество</label>
      <input type="text" class="form-control" id="middle_name" v-model="formData.middle_name" />
    </div>
    <div class="mb-3">
      <label for="post" class="form-label">Должность</label>
      <input type="text" class="form-control" id="post" v-model="formData.post" />
    </div>
    <div class="mb-3">
      <label for="phone_number" class="form-label">Номер телефона</label>
      <input type="text" class="form-control" id="phone_number" v-model="formData.phone_number" />
    </div>
    <button type="button" class="btn btn-primary" @click="submitForm">{{ props.buttonText }}</button>
  </form>
</template>
