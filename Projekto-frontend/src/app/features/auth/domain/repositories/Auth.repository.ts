import {Observable} from 'rxjs';
import {User} from '../entities/user.model';

export abstract class AuthRepository {
  abstract signInWithEmailAndPassword(email: string, password: string): Observable<User>;

  abstract signUpUser(user: User): Observable<User>;

  abstract getByUserId(userId: string): Observable<User>;
}

