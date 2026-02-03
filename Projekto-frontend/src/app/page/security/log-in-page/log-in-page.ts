import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { UserService } from '../../../services/user-service';

@Component({
  selector: 'app-log-in-page',
  imports: [RouterLink],
  templateUrl: './log-in-page.html',
  styleUrl: './log-in-page.scss',
})
export class LogInPage {
  testData = {
    name: 'ravindu',
    value: 20,
  };

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private userService: UserService) {}

  onSubmit(): void {
    this.userService.sendTestData(this.testData).subscribe(
      (response) => {
        console.log('Success:', response);
        alert('Data submitted successfully!');
      },
      (error) => {
        console.error('Error:', error);
        alert('Failed to submit data.');
      },
    );
  }
}
