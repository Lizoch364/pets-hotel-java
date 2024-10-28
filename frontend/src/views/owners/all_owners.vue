<script setup>
import { onMounted, ref } from "vue";
import { deleteOwner, getAllOwners } from "../../api/owners";

const owners = ref([]);

onMounted(async () => {
  await fetchData();
});

const fetchData = async () => {
  owners.value = (await getAllOwners()) ?? [];
};

const handleDeleteOwner = async (id) => {
  await deleteOwner(id);
  await fetchData();
};
</script>

<template>
  <main class="container">
    <div class="d-flex justify-content-between align-items-center w-100">
      <h2 class="h2">Хозяины</h2>
      <div>
        <RouterLink :to="{ name: 'create_owner' }" class="btn btn-primary btn-sm"> Создать </RouterLink>
      </div>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Имя</th>
          <th scope="col">Фамилия</th>
          <th scope="col">Отчество</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="owner in owners" :key="owner.id">
          <th scope="row">{{ owner.id }}</th>
          <td>{{ owner.name }}</td>
          <td>{{ owner.surname }}</td>
          <td>{{ owner.middle_name }}</td>
          <td>
            <div class="d-flex gap-1">
              <RouterLink class="btn btn-secondary btn-sm" :to="{ name: 'update_owner', params: { id: owner.id } }">
                Обновить
              </RouterLink>
              <button class="btn btn-outline-danger btn-sm" @click="handleDeleteOwner(owner.id)">Удалить</button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>
