import {AuthRepository} from '../../domain/repositories/Auth.repository';
import {User} from '../../domain/entities/user.model';

export class SaveUserUseCase {
  constructor(private repository: AuthRepository) {
  }

  execute(user: User) {
    return this.repository.signUpUser(user);
  }
}
