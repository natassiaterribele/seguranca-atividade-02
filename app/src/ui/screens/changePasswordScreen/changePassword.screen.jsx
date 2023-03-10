import { useChangePasswordInputs } from '../../../hook/index';
import { Button, FormContainer, PasswordInput } from '../../components/index';

export function ChangePasswordScreen() {
  const { formInputs, handleChange, handleSubmit } = useChangePasswordInputs();

  return (
    <form onSubmit={handleSubmit}>
      <FormContainer>
        <PasswordInput
          labelText="Senha"
          inputName="password"
          forPassword="password"
          inputValue={formInputs.password}
          onChange={handleChange}
        />
        <div className="adjust-button">
          <Button>Alterar</Button>
        </div>
      </FormContainer>
    </form>
  );
}
