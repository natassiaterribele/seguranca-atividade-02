import { axiosInstance } from '../_base/axiosInstance';

const URL_USER_EDIT = '/usuarios/editar';

export async function editUser({ username, phone, imageUrl }) {
  const response = await axiosInstance.put(URL_USER_EDIT, {
    nome: username,
    telefone: phone,
    fotoUrl: imageUrl,
  });
  return response.data;
}
