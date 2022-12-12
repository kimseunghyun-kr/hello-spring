package repository;

import domain.Member;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

//        shift + f6
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        assertThat(member1).isEqualTo(repository.findByName("spring1").get());
    }
}