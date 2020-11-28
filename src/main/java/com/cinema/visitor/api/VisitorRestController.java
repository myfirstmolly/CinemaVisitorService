package com.cinema.visitor.api;

import com.cinema.visitor.model.Visitor;
import com.cinema.visitor.model.WithdrawDto;
import com.cinema.visitor.service.VisitorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/visitor")
@AllArgsConstructor
@NoArgsConstructor
public class VisitorRestController {

    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public Visitor addVisitor(@RequestBody Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("{id}")
    public Visitor getVisitorById(@PathVariable(name = "id") UUID id) {
        return visitorService.getVisitorById(id);
    }

    @PutMapping("withdraw/{id}")
    public Visitor reduceBalance(@PathVariable(name = "id") UUID id,
                                 @RequestBody(required = false) WithdrawDto toWithdraw) {
        return visitorService.updateVisitorBalance(id, toWithdraw);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        visitorService.deleteVisitorById(id);
    }

}
