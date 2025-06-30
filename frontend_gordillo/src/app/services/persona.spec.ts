import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PersonaService } from './persona.service';

describe('PersonaService', () => {
  let service: PersonaService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PersonaService]
    });
    service = TestBed.inject(PersonaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});