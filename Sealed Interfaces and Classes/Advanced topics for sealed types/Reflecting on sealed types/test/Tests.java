import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import core.Chair;
import core.Computer;
import core.NonSealed;
import dto.v1.ChairDto;
import dto.v1.ComputerDto;
import dto.v1.ProductDto;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void noExceptionIfAllCovered() {
    var mapper = PolymorphicMapper.builder(ProductDto.class)
        .fromTo(ChairDto.class, Chair.class)
        .fromTo(ComputerDto.class, Computer.class)
        .build();

    assertEquals("maps normally if all permitted subclasses covered", Chair.class, mapper.getMapping(ChairDto.class));
  }

  @Test
  public void exceptionIfSubclassMissing() {
    try {
      PolymorphicMapper.builder(ProductDto.class)
          .fromTo(ComputerDto.class, Computer.class)
          .build();
      fail("No exception thrown");
    } catch (MissingPolymorphicMappingException e) {
      assertEquals("should list missing ChairDto mapping in missingClasses of exception", Set.of(ChairDto.class), e.getMissingClasses());
    }
  }

  @Test
  public void noExceptionIfNotSealed() {
    try {
      PolymorphicMapper.builder(NonSealed.class).build();
    } catch (MissingPolymorphicMappingException e) {
      fail("You are not supposed to throw an exception for non-sealed classes");
    }
  }
}