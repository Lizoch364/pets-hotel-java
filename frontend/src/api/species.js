import { http } from "./axios";

const BASE_URL = "/api/v1/hotels/species";

export const getAllSpecies = async () => {
  const data = await http.get(BASE_URL);
  return data.data;
};

export const getOneSpecies = async (id) => {
  const data = await http.get(`${BASE_URL}/${id}`);
  return data.data;
};
