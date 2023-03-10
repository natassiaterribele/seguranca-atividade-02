import { useFormInputs } from '../../../hook/index';
import {
  Button,
  FormContainer,
  LinkButton,
  PasswordInput,
  TextInput,
} from '../../components/index';

export function UserLoginScreen() {
  const { formInputs, handleChange, handleSubmit } = useFormInputs();

  return (
    <form onSubmit={handleSubmit}>
      <FormContainer>
        <TextInput
          placeholder="seunome@email.com"
          labelText="Email"
          inputName="username"
          inputValue={formInputs.username}
          onChange={handleChange}
        />
        <PasswordInput
          labelText="Senha"
          inputName="password"
          forPassword="password"
          inputValue={formInputs.password}
          onChange={handleChange}
        />
        <div className="adjust-button">
          <Button>Entrar</Button>
        </div>
        <LinkButton linkButtonName="Cadastre-se" link="/register" />
      </FormContainer>
    </form>
  );
}
