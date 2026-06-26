import {AuthRepository} from '../../domain/repositories/Auth.repository';

export class SignInUserUsecase {
  constructor(private repository: AuthRepository) {
  }

  execute(username: string, password: string) {
    return this.repository.signInWithEmailAndPassword(username, password);
  }
}
