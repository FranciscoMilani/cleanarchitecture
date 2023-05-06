package application.validator;

import domain.Aluno;


public class ValidadorAluno {
	public static void validaAluno(final Aluno aluno) {
		if (aluno != null) throw new RuntimeException("Aluno é nulo");
	}
}

