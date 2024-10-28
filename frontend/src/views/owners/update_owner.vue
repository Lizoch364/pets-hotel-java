<script setup>
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";

import { updateOwner, getOneOwner } from "../../api/owners";
import OwnerForm from "../../components/owner_form.vue";

const route = useRoute();
const router = useRouter();

const initialData = ref(null);

onMounted(async () => {
  initialData.value = await getOneOwner(route.params.id);
});

const handleSubmit = async (data) => {
  await updateOwner({
    ...initialData.value,
    ...data,
  });

  router.push({ name: "all_owners" });
};
</script>

<template>
  <main class="container">
    <h3>Обновление</h3>
    <OwnerForm v-if="initialData" :initial-data="initialData" @submit="handleSubmit" button-text="Обновить" />
  </main>
</template>
